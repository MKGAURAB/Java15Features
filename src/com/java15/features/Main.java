package com.java15.features;

public class Main {

    public static void main(String[] args) {
	    Expr e = new Add(
	            new Constant(1),
                new Mul(new Constant(7), new Constant(6))
        );

        System.out.println("%s = %d".formatted(e, e.eval()));
    }
}
