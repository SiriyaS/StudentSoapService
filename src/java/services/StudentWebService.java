/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.Student;
import model.StudentTable;

/**
 *
 * @author siriya_s
 */
@WebService(serviceName = "StudentWebService")
public class StudentWebService {
    /**
     * Web service operation
     */
    @WebMethod(operationName = "FindAllStudent")
    public List<Student> findAllStudent() {
        List<Student> studs = StudentTable.findAllStudent();
        return studs;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "findStudentById")
    public Student findStudentById(@WebParam(name = "id") int id) {
        Student stud = StudentTable.findStudentById(id);
        return stud;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findStudentByName")
    public List<Student> findStudentByName(@WebParam(name = "name") String name) {
        List<Student> studs = StudentTable.findStudentByName(name);
        return studs;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "findStudentByGPA")
    public List<Student> findStudentByGPA(@WebParam(name = "gpa") Double gpa) {
        List<Student> studs = StudentTable.findStudentByGPA(gpa);
        return studs;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertStudent")
    public String insertStudent(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "gpa") Double gpa) {
        Student stud = new Student(id, name, gpa);
        StudentTable.insertStudent(stud);
        return "Insert successfully";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateStudentById")
    public String updateStudentById(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "gpa") Double gpa) {
        StudentTable.updateStudent(id, name, gpa);
        return "Update Successfully";
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteStudentById")
    public String deleteStudentById(@WebParam(name = "id") int id) {
        StudentTable.removeStudent(id);
        return "Delete successfully";
    }
}
