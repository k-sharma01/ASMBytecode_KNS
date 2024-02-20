import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * This program generates a class file with the ASM library to implement a while loop
 * @author Kirin Sharma
 * @version 1.0
 */

 public class gen7
 {

    public static void main(String[] args) 
    {
        // Create class and main method
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program7", null, "java/lang/Object",null);
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();

        // Relevant lables for jump instructions
        Label whileHeader = new Label();
        Label end = new Label();

        // Create counter variable for while loop
        mv.visitLdcInsn(1);
        mv.visitVarInsn(Opcodes.ISTORE, 0);

        // While loop body
        mv.visitLabel(whileHeader);
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitLdcInsn(5);
        mv.visitJumpInsn(Opcodes.IF_ICMPGT, end); // exit while loop if counter is greater than 5
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitLdcInsn("Current iteration: ");
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

        // Increment counter variable and jump back top
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitLdcInsn(1);
        mv.visitInsn(Opcodes.IADD);
        mv.visitVarInsn(Opcodes.ISTORE, 0);
        mv.visitJumpInsn(Opcodes.GOTO, whileHeader);

        // Return out of main, and close the method visitor
        mv.visitLabel(end);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        // Write bytes created by above code to file; writeFile credit: Dr. Robert Kelly
        byte[] b = cw.toByteArray();
        Utilities.writeFile(b, "program7.class");

    } // end main

 } // end class