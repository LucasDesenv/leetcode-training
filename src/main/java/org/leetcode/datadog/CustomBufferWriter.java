package org.leetcode.datadog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Your task is to create a new file type with a “Buffer”.
 * Every time you write data to this file, you use the Write method like write(“hello world”), but if you have enough buffer in memory (buffer_size), you write to buffer first.
 * Only write to disk when the buffer is full (using the flush method to write to disk).
 * Implement both the Write and flush functions
 */
public class CustomBufferWriter {

  private final FileOutputStream fileInputStream;
  private final int memoryLimit;
  private byte[] buffer;
  private int bufferCounter = 0;

  public CustomBufferWriter(String fileName, int memoryLimit) throws IOException {
    File file = new File(fileName);
    if (file.exists()){
      assert file.delete();
    }

    assert file.createNewFile();

    this.fileInputStream = new FileOutputStream(file);
    this.memoryLimit = memoryLimit;
    this.buffer = new byte[memoryLimit];
  }

  public void write(byte[] dataToWrite) throws IOException {
    System.out.println("Writing");

    for (byte data : dataToWrite) {
      if (flush(false)) {
        bufferCounter = 0;
      }

      buffer[bufferCounter++] = data;
    }

    flush(true);
  }

  public boolean flush(boolean force) throws IOException {
    if (!force && bufferCounter < memoryLimit) {
      return false;
    }

    System.out.println("Flushing");

    fileInputStream.write(buffer);
    fileInputStream.flush();
    buffer = new byte[memoryLimit];

    return true;
  }

  public static void main(String[] args) throws IOException {
    byte[] data = "Testing this class".getBytes(StandardCharsets.UTF_8);
    CustomBufferWriter test100kb = new CustomBufferWriter("test100kb.txt", data.length*2);
    test100kb.write(data);
  }

}
