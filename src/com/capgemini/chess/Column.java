package com.capgemini.chess;

public enum Column {
	A(1), B(2), C(3), D(4), E(5), F(6), G(7), H(8);

	private final int id;

	private Column(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

}