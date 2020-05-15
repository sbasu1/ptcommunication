package org.launchcode.ptcommunications.controllers;


import org.launchcode.ptcommunications.models.Student;
import org.launchcode.ptcommunications.models.User;
import org.launchcode.ptcommunications.models.dto.LoginFormDTO;
import org.launchcode.ptcommunications.repository.StudentRepository;
import org.launchcode.ptcommunications.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class PTCommunicationController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/ptcomm")
    public String displayListOfStudents(Model model){
        Iterable<Student> students;
        students = studentRepository.findAll();
        model.addAttribute("allStudents", students);
        return "listOfStudent";
    }

    @GetMapping("/addStudent")
    public String displayAddStudentForm(Model model) {
        model.addAttribute("student",new Student());
        model.addAttribute("title","Add Student");
        return "addStudent";
    }

    @PostMapping("/addStudent")
    public String processAddStudentForm(@ModelAttribute @Valid Student student,
                                        Errors errors, HttpServletRequest request,
                                        Model model) {
        studentRepository.save(student);
        return "redirect:/ptcomm";
    }




}
