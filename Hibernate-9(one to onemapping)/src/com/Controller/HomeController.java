package com.Controller;

import com.Service.SerciceClass;
import com.Service.ServiceImpl;

public class HomeController {
public static void main(String[] args) {
	
	SerciceClass s=new ServiceImpl();
	
	//s.addpersonwithadhar();
	//s.getpersonOnlyUsingPersonId();
	//s.getadharOnlyUsingPesronId();
	//s.updatePersonOnlyUsingPersonId();
	//s.updateadharonlyUsingPersonId();
	//s.addPersonOnly();
	//s.addAdharOnly();
	s.deletePersonOnlyUsingPersonID();
}
}
