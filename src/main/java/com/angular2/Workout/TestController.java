package com.angular2.Workout;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular2.model.Hero;

@RestController
@RequestMapping(value = "/hero")
public class TestController 
{
	@RequestMapping(value = "/all")
	public List<Hero> getHeroes()
	{
		return getHeroList();
	}
	
	@RequestMapping(value = "/{id}")
	public Hero getHeroById(@PathVariable("id") Integer id)
	{
		return findHeroById(id);
	}

	
	/* ************************ Private Methods *********************** */
	private Hero findHeroById(Integer id) 
	{
		List<Hero> heroList = getHeroList();
		return heroList.get(id);
	}

	private List<Hero> getHeroList() 
	{
		List<Hero> heroList = new ArrayList<Hero>();
		for(int i=1; i<=5; i++)
		{
			Hero h = new Hero();
			h.setId(i);
			h.setName("Hero_Name_"+i);
			heroList.add(h);
		}
		return heroList;
	}
}
