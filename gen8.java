import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * This program generates a class file with the ASM library to implement an if...else statement
 * @author Kirin Sharma
 * @version 1.0
 */

 public class gen8
 {

    public static void main(String[] args) 
    {
    
        // Create class and main method
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program8", null, "java/lang/Object",null);
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();

        // Labels for jump instructions
        Label elseIfLabel = new Label();
        Label elseLabel = new Label();
        Label end = new Label();

        // Compares longs as a condition and stores its result to be used for jump instructions
        mv.visitLdcInsn(880l);
        mv.visitLdcInsn(589l);
        mv.visitInsn(Opcodes.LCMP);
        mv.visitVarInsn(Opcodes.ISTORE, 0);

        // Jump instructions determining which block of the if...else if...else statement to run
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitJumpInsn(Opcodes.IFGT, elseIfLabel);
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitJumpInsn(Opcodes.IFEQ, elseLabel);

        // Code inside if statement
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("This prints if the first value loaded onto stack is LESS THAN the second one.");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitJumpInsn(Opcodes.GOTO, end);

        // Code inside else if statement
        mv.visitLabel(elseIfLabel);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("This prints if the first value loaded onto stack is GREATER THAN the second one.");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitJumpInsn(Opcodes.GOTO, end);

        // Code inside else statement
        mv.visitLabel(elseLabel);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("This prints if the two values are EQUAL.");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);

        // Return out of main, and close the method visitor
        mv.visitLabel(end);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        // Write bytes created by above code to file; writeFile credit: Dr. Robert Kelly
        byte[] b = cw.toByteArray();
        Utilities.writeFile(b, "program8.class");

    } // end main

 } // end class