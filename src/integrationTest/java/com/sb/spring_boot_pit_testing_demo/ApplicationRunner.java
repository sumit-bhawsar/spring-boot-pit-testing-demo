package com.sb.spring_boot_pit_testing_demo;

public class ApplicationRunner {
    public static void main(String[] args) {
        String[] args1 = new String[]{"--spring.profiles.active=int-test"};
        SpringBootPitTestingDemoApplication.main(args1);
    }
}
