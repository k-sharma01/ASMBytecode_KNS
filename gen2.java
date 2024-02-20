import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * This program generates a class file with the ASM library to store, subtract, and print the resulting values of different types
 * @author Kirin Sharma
 * @version 1.0
 */

 public class gen2
 {

    public static void main(String[] args) 
    {
        // Create class and main method
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program2", null, "java/lang/Object",null);
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();


        // Load and store integers
        mv.visitLdcInsn(75);
        mv.visitVarInsn(Opcodes.ISTORE, 0);
        mv.visitLdcInsn(90);
        mv.visitVarInsn(Opcodes.ISTORE, 1);

        // Load integers, subtract them and store result (expected -15)
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitInsn(Opcodes.ISUB);
        mv.visitVarInsn(Opcodes.ISTORE, 2);

        // Print integer subtraction result
        mv.visitLdcInsn("Integer subtraction result: ");
        mv.visitVarInsn(Opcodes.ASTORE, 18);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 18);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);

        // Load and store longs
        mv.visitLdcInsn(35000000000l);
        mv.visitVarInsn(Opcodes.LSTORE, 3);
        mv.visitLdcInsn(14000000000l);
        mv.visitVarInsn(Opcodes.LSTORE, 5);

        // Load longs, subtract them and store result (expected 21000000000)
        mv.visitVarInsn(Opcodes.LLOAD, 3);
        mv.visitVarInsn(Opcodes.LLOAD, 5);
        mv.visitInsn(Opcodes.LSUB);
        mv.visitVarInsn(Opcodes.LSTORE, 7);

        // Print long subtraction result
        mv.visitLdcInsn("Long subtraction result: ");
        mv.visitVarInsn(Opcodes.ASTORE, 35);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 35);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.LLOAD, 7);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

        // Load and store floats
        mv.visitLdcInsn(6.513f);
        mv.visitVarInsn(Opcodes.FSTORE, 9);
        mv.visitLdcInsn(1.2546f);
        mv.visitVarInsn(Opcodes.FSTORE, 10);

        // Load floats, subtract them and store result (expected 5.2584)
        mv.visitVarInsn(Opcodes.FLOAD, 9);
        mv.visitVarInsn(Opcodes.FLOAD, 10);
        mv.visitInsn(Opcodes.FSUB);
        mv.visitVarInsn(Opcodes.FSTORE, 11);

        // Print float subtraction result
        mv.visitLdcInsn("Float subtraction result: ");
        mv.visitVarInsn(Opcodes.ASTORE, 45);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 45);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.FLOAD, 11);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

        // Load and store doubles
        mv.visitLdcInsn(3.1415926);
        mv.visitVarInsn(Opcodes.DSTORE, 12);
        mv.visitLdcInsn(2.7182818);
        mv.visitVarInsn(Opcodes.DSTORE, 14);

        // Load doubles, subtract them and store result (expected 0.4233108)
        mv.visitVarInsn(Opcodes.DLOAD, 12);
        mv.visitVarInsn(Opcodes.DLOAD, 14);
        mv.visitInsn(Opcodes.DSUB);
        mv.visitVarInsn(Opcodes.DSTORE, 16);

        // Print double subtraction result
        mv.visitLdcInsn("Double subtraction result: ");
        mv.visitVarInsn(Opcodes.ASTORE, 57);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 57);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.DLOAD, 16);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

        // Return out of main, and close the method visitor
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        // Write bytes created by above code to file; writeFile credit: Dr. Robert Kelly
        byte[] b = cw.toByteArray();
        Utilities.writeFile(b, "program2.class");

    } // end main

 } // end class
