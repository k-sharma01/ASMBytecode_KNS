import org.objectweb.asm.*;

/**
 * CS 322 Assignment 3
 * This program generates a class file with the ASM library to compare values, and print which is bigger
 * @author Kirin Sharma
 * @version 1.0
 */

 public class gen4
 {

    public static void main(String[] args) 
    {
        
        // Create class and main method
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC,"program4", null, "java/lang/Object",null);
        MethodVisitor mv = cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_STATIC, "main", "([Ljava/lang/String;)V", null, null);
        mv.visitCode();

        // Labels for jump instructions
        Label intGreater = new Label();
        Label intLess = new Label();
        Label shortComp = new Label();
        Label shortGreater = new Label();
        Label shortLess = new Label();
        Label longComp = new Label();
        Label longGreater = new Label();
        Label longLess = new Label();
        Label end = new Label();

        // Store string and print first part of output for integer result
        mv.visitLdcInsn("Bigger value: ");
        mv.visitVarInsn(Opcodes.ASTORE, 2);
        mv.visitLdcInsn("Values are equal!");
        mv.visitVarInsn(Opcodes.ASTORE, 17);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 2);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);

        // Load and store int values
        mv.visitLdcInsn(1205);
        mv.visitVarInsn(Opcodes.ISTORE, 0);
        mv.visitLdcInsn(113);
        mv.visitVarInsn(Opcodes.ISTORE, 1);

        // Compares ints and jumps to either greater or less label depending on comparison result
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitJumpInsn(Opcodes.IF_ICMPGT, intGreater);
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitJumpInsn(Opcodes.IF_ICMPLT, intLess);

        // Executes if ints are equal
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 17);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitJumpInsn(Opcodes.GOTO, longComp);

        // Executes if int in index 0 is greater than int in index 1: prints bigger value
        mv.visitLabel(intGreater);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 0);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);  
        mv.visitJumpInsn(Opcodes.GOTO, longComp);
        
        // Executes if int in index 0 is less than int in index 1: prints bigger value
        mv.visitLabel(intLess);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 1);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);        
        mv.visitJumpInsn(Opcodes.GOTO, longComp);

        // Print first part of output for longs
        mv.visitLabel(longComp);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 2);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);

        // Load and store long values
        mv.visitLdcInsn(540000l);
        mv.visitVarInsn(Opcodes.LSTORE, 11);
        mv.visitLdcInsn(1700000l);
        mv.visitVarInsn(Opcodes.LSTORE, 13);

        // Compare long values and jump to correct block
        mv.visitVarInsn(Opcodes.LLOAD, 11);
        mv.visitVarInsn(Opcodes.LLOAD, 13);        
        mv.visitInsn(Opcodes.LCMP);
        mv.visitJumpInsn(Opcodes.IFGT, longGreater);
        mv.visitVarInsn(Opcodes.LLOAD, 11);
        mv.visitVarInsn(Opcodes.LLOAD, 13);        
        mv.visitInsn(Opcodes.LCMP);  
        mv.visitJumpInsn(Opcodes.IFLT, longLess);   
        
        // Executes if longs are equal
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 17);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitJumpInsn(Opcodes.GOTO, shortComp);

        // Executes if long in index 11 is greater than long in index 13: prints bigger value
        mv.visitLabel(longGreater);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.LLOAD, 11);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);  
        mv.visitJumpInsn(Opcodes.GOTO, shortComp);
        
        // Executes if long in index 11 is less than long in index 13: prints bigger value
        mv.visitLabel(longLess);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.LLOAD, 13);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(J)V", false);        
        mv.visitJumpInsn(Opcodes.GOTO, shortComp);

        // Print first part of output for shorts
        mv.visitLabel(shortComp);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 2);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "print", "(Ljava/lang/String;)V", false);

        // Load short values into memory
        mv.visitIntInsn(Opcodes.SIPUSH, 58);
        mv.visitVarInsn(Opcodes.ISTORE, 15);
        mv.visitIntInsn(Opcodes.SIPUSH, 67);
        mv.visitVarInsn(Opcodes.ISTORE, 16);

        // Compares the shorts and jumps to either greater or less label depending on comparison result
        mv.visitVarInsn(Opcodes.ILOAD, 15);
        mv.visitVarInsn(Opcodes.ILOAD, 16);
        mv.visitJumpInsn(Opcodes.IF_ICMPGT, shortGreater);
        mv.visitVarInsn(Opcodes.ILOAD, 15);
        mv.visitVarInsn(Opcodes.ILOAD, 16);
        mv.visitJumpInsn(Opcodes.IF_ICMPLT, shortLess); 
        
        // Executes if shorts are equal
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ALOAD, 17);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
        mv.visitJumpInsn(Opcodes.GOTO, end);

        // Executes if short in index 15 is greater than long in index 16: prints bigger value
        mv.visitLabel(shortGreater);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 15);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);  
        mv.visitJumpInsn(Opcodes.GOTO, end);
        
        // Executes if long in index 15 is less than long in index 16: prints bigger value
        mv.visitLabel(shortLess);
        mv.visitFieldInsn(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
        mv.visitVarInsn(Opcodes.ILOAD, 16);
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(I)V", false);        
        mv.visitJumpInsn(Opcodes.GOTO, end);

        // Return out of main, and close the method visitor
        mv.visitLabel(end);
        mv.visitInsn(Opcodes.RETURN);
        mv.visitMaxs(0,0);
        mv.visitEnd();

        // Write bytes created by above code to file; writeFile credit: Dr. Robert Kelly
        byte[] b = cw.toByteArray();
        Utilities.writeFile(b, "program4.class");

    } // end main

 } // end class