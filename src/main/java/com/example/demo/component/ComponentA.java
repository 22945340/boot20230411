package com.example.demo.component;

public class ComponentA {

	private ComponentB comp;
	
	
	public ComponentA(ComponentB comp) {
		this.comp = comp;
	}
	
	public void SetComp(ComponentB comp) {
		this.comp = comp;
	}
	
	public ComponentB GetComp() {
		return comp;
	}
}
