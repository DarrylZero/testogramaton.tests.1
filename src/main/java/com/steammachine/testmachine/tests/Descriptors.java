package com.steammachine.testmachine.tests;

import com.steammachine.testmachine.sdk.TaskDescription;
import com.steammachine.testmachine.sdk.TaskDescriptor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Descriptors implements TaskDescription {

    private static final Pattern DESCRIPTION_PATTERN = Pattern.compile("^description.\\S*.txt$");

    @Override
    public void get(Consumer<TaskDescriptor> consumer) {
        File file = new File(Descriptors.class.getClassLoader().getResource("descriptions").getFile());
        if (file.list() != null) {
            Stream.of(file.list()).map(name -> new File(file, name))
                  .filter(File::isFile)
                  .filter(file1 -> DESCRIPTION_PATTERN.matcher(file1.getName()).matches())
                  .map(file2 -> {
                      Matcher matcher = DESCRIPTION_PATTERN.matcher(file2.getName());
                      matcher.find();
                      String group = matcher.group();
                      int first = group.indexOf(".");
                      int last = group.lastIndexOf(".");
                      String testGroup = group.substring(first + 1, last);

                      try (BufferedReader reader = new BufferedReader(
                              new InputStreamReader(new FileInputStream(file2)))) {
                          String description = reader.lines().collect(Collectors.joining("\r\n"));
                          return new TaskDescriptor() {
                              @Override
                              public String testGroup() {
                                  return testGroup;
                              }

                              @Override
                              public String description() {
                                  return description;
                              }
                          };
                      } catch (IOException e) {
                          throw new IllegalStateException(e);
                      }
                  }).forEach(consumer);
        }
    }

    public static void main(String[] args) {
        new Descriptors().get(new Consumer<TaskDescriptor>() {
            @Override
            public void accept(TaskDescriptor taskDescriptor) {
            }
        });

    }

}
