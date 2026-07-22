package com.cohort.alpha;

public class PackageNeighbor {
    public static void main(String[] args) {
        AccessHolder holder = new AccessHolder();
        holder.publicMethod();
        holder.protectedMethod();
        holder.defaultMethod();
        // holder.privateMethod(); // Compile error: privateMethod() has private access in AccessHolder
    }
}