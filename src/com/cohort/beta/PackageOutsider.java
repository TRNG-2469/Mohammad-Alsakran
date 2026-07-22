package com.cohort.beta;

import com.cohort.alpha.AccessHolder;

public class PackageOutsider {
    public static void main(String[] args) {
        AccessHolder holder = new AccessHolder();
        holder.publicMethod();
        // holder.protectedMethod(); // Compile error: protectedMethod() has protected access in AccessHolder
        // holder.defaultMethod();   // Compile error: defaultMethod() is not public in AccessHolder; cannot be accessed from outside package
        // holder.privateMethod();   // Compile error: privateMethod() has private access in AccessHolder
    }
}