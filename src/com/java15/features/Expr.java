package com.java15.features;

public sealed interface Expr {
    int eval();
}

// Declaring Subclass in the same Source File will allow the compiler
// to assume that these are subclass of the above-declared sealed interface
// records are implicitly static and final

record Constant(int value) implements Expr {
    @Override
    public int eval() {
        return value;
    }
}

record Add(Expr lval, Expr rval) implements Expr
{
    @Override
    public int eval() {
        return lval.eval() + rval.eval();
    }
}

record Mul(Expr lval, Expr rval) implements Expr{
    @Override
    public int eval() {
        return lval.eval() * rval.eval();
    }
}
