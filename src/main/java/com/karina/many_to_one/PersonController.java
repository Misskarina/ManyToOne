package com.karina.many_to_one;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	PersonRepository prepo;
	@Autowired
	VehiclesRepository vrepo;
	
	@RequestMapping("/save")
	public String save()
	{
		Person p=new Person();
		p.setPname("Mr.Pradeep");
		
		Vehicles v=new Vehicles();
		v.setVname("AUDI");
		v.setVno(4567);
		
		Vehicles v1=new Vehicles();
		v1.setVname("BMW");
		v1.setVno(4234);
		
		Vehicles v2=new Vehicles();
		v2.setVname("Enova");
		v2.setVno(6787);
		
		List<Vehicles> list=new ArrayList<Vehicles>();
		list.add(v);list.add(v1);list.add(v2);
		
		v.setPerson(p);
		v1.setPerson(p);
		v2.setPerson(p);
		p.setVehicles(list);
		
		prepo.save(p);
		return "data save";
		
	}
	
	@RequestMapping("/all")
	public  List<Vehicles> all()
	{
		return vrepo.findAll();
	}
	
	@RequestMapping("/new/{vid}")
	public List<Vehicles> newby(@PathVariable int vid)
	{
		return vrepo.findByVid(vid);
	}
	
	@RequestMapping("/some/{vname}")
	public List<Vehicles> someby(@PathVariable String vname)
	{
		return vrepo.findByVname(vname);
	}
	
	
	
	

}
