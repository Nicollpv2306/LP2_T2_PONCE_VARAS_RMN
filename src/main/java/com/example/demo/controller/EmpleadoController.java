package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.AreaEntity;
import com.example.demo.entity.EmpleadoEntity;
import com.example.demo.repository.AreaRepository;
import com.example.demo.repository.EmpleadoRepository;

@Controller
public class EmpleadoController {
	@Autowired
	private EmpleadoRepository empRepository;

	@Autowired
	private AreaRepository areRepository;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

	@GetMapping("/listar_empleados")
	public String listarEmpleados(Model model) {
		List<EmpleadoEntity> empleado = empRepository.findAll();
		model.addAttribute("empleado", empleado);
		return("/empleados/listar");
	}

	@GetMapping("/eliminar_empleados/{id}")
	public String eliminarEmpleados(@PathVariable("id")Integer id) {
		empRepository.deleteById(id);
		return("redirect:/listar_empleados");
	}

	@GetMapping("/registrar_empleados")
	public String mostrarVistaRegistrarEmpleados(Model model) {
		List<AreaEntity> area = areRepository.findAll();
		model.addAttribute("area", area);
		model.addAttribute("empleado", new EmpleadoEntity());
		return("/empleados/registrar");
	}

	@PostMapping("/registrar_empleados")
	public String registarEmpleado(@ModelAttribute EmpleadoEntity empleado, Model model) {
		empRepository.save(empleado);
		return("redirect:/listar_empleados");
	}

	@GetMapping("/editar_empleado/{id}")
	public String mostrarVistaEditarEmpleado(@PathVariable("id")Integer id, Model model) {
		EmpleadoEntity empleado = empRepository.findById(id).get();
        List<AreaEntity> areas = areRepository.findAll();
        model.addAttribute("areas", areas);
        model.addAttribute("empleado", empleado);
		return("/empleados/editar");
	}

	@PostMapping("/editar_empleado/{id}")
    public String editarEmpleado(@PathVariable("id") Integer id, @ModelAttribute EmpleadoEntity empleado, Model model) {
        empleado.setDniEmpleado(id);
        empRepository.save(empleado);
        return ("redirect:/listar_empleados");
    }

	@GetMapping("/detalle_empleado/{id}")
    public String detalleEmpleado(@PathVariable("id") Integer id, Model model) {
        EmpleadoEntity empleado = empRepository.findById(id).get();
        model.addAttribute("empleado", empleado);
        return "/empleados/detalle";
    }
}
