import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * This program generates a class file with the ASM library to store, multiply, and print values of different types
 * @author Kirin Sharma
 * @version 1.0
 */

public class gen1 
{

    public static void main(String[] args) 
    {
        // Create class and main method
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program1", null, "java/lang/Object",null);
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();

        // Load and store integers
        mv.visitLdcInsn(4);
        mv.visitVarInsn(Opcodes.ISTORE, 1);
        mv.visitLdcInsn(5);
        mv.visitVarInsn(Opcodes.ISTORE, 2);

        // Load integers, multiply them and store result (expected 20)
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitVarInsn(Opcodes.ILOAD, 2);
        mv.visitInsn(Opcodes.IMUL);
        mv.visitVarInsn(Opcodes.ISTORE, 3);

        // Print integer multiplication result to the screen
        mv.visitLdcInsn("Integer multiplication result: ");
        mv.visitVarInsn(Opcodes.ASTORE, 18);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 18);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 3);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);
        
        // Load and store longs
        mv.visitLdcInsn(1500000000l);
        mv.visitVarInsn(Opcodes.LSTORE, 4);
        mv.visitLdcInsn(2l);
        mv.visitVarInsn(Opcodes.LSTORE, 6);
        
        // Load longs, multiply them and store result (expected 3000000000)
        mv.visitVarInsn(Opcodes.LLOAD, 4);
        mv.visitVarInsn(Opcodes.LLOAD, 6);
        mv.visitInsn(Opcodes.LMUL);
        mv.visitVarInsn(Opcodes.LSTORE, 8);

        // Print long multiplication result to the screen
        mv.visitLdcInsn("Long multiplication result: ");
        mv.visitVarInsn(Opcodes.ASTORE, 35);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 35);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.LLOAD, 8);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);

        // Load and store floats
        mv.visitLdcInsn(5.25f);
        mv.visitVarInsn(Opcodes.FSTORE, 10);
        mv.visitLdcInsn(6.552f);
        mv.visitVarInsn(Opcodes.FSTORE, 11);
        
        // Load floats, multiply them and store result (expected 34.398)
        mv.visitVarInsn(Opcodes.FLOAD, 10);
        mv.visitVarInsn(Opcodes.FLOAD, 11);
        mv.visitInsn(Opcodes.FMUL);
        mv.visitVarInsn(Opcodes.FSTORE, 12);

        // Print float multiplication result to the screen
        mv.visitLdcInsn("Float multiplication result: ");
        mv.visitVarInsn(Opcodes.ASTORE, 40);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 40);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.FLOAD, 12);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(F)V", false);

        // Load and store doubles
        mv.visitLdcInsn(15.67);
        mv.visitVarInsn(Opcodes.DSTORE, 13);
        mv.visitLdcInsn(12.9087);
        mv.visitVarInsn(Opcodes.DSTORE, 15);
        
        // Load doubles, multiply them and store result (expected 202.279329)
        mv.visitVarInsn(Opcodes.DLOAD, 13);
        mv.visitVarInsn(Opcodes.DLOAD, 15);
        mv.visitInsn(Opcodes.DMUL);
        mv.visitVarInsn(Opcodes.DSTORE, 17);

        // Print double multiplication result to the screen
        mv.visitLdcInsn("Double multiplication result: ");
        mv.visitVarInsn(Opcodes.ASTORE, 57);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 57);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.DLOAD, 17);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);

        // Return out of main, and close the method visitor
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0, 0);
        mv.visitEnd();

        // Write bytes created by above code to file; writeFile credit: Dr. Robert Kelly
        byte[] b = cw.toByteArray();
        Utilities.writeFile(b, "program1.class");

    } // end main

} // end class
