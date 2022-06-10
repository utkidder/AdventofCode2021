package com.adventofcode.app;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App 
{
    public static void main( String[] args ) throws IOException
    {	
		String[] input = parseInput();
		System.out.println(partOne(input));
		System.out.println(partTwo(input));
		
    }

	private static String[] parseInput() throws IOException {
		return Files.lines(Paths.get("./src/main/java/com/adventofcode/inputs/Input.txt"))
			.map(String::valueOf)
			.toArray(String[]::new);
	}

	private static Integer partOne(String[] input){
		Integer depth=0;
		Integer h_pos=0;
		Integer result;
		String[] delta;
		
		for(int i=0; i<input.length; i++){
			delta = input[i].split(" ");
			if((delta[0]).equals("down")){
				depth = depth + Integer.parseInt(delta[1]);
			}
			else if((delta[0]).equals("up")){
				depth = depth - Integer.parseInt(delta[1]);
			}
			else {
				h_pos = h_pos + Integer.parseInt(delta[1]);
			}
		}
		result = h_pos * depth;

		return result;
	}

	private static Integer partTwo(String[] input){
		Integer depth=0;
		Integer h_pos=0;
		Integer aim=0;
		Integer result;
		String[] delta;
		
		for(int i=0; i<input.length; i++){
			delta = input[i].split(" ");
			if((delta[0]).equals("down")){
				aim = aim + Integer.parseInt(delta[1]);
			}
			else if((delta[0]).equals("up")){
				aim = aim - Integer.parseInt(delta[1]);
			}
			else {
				h_pos = h_pos + Integer.parseInt(delta[1]);
				depth = depth + aim*Integer.parseInt(delta[1]);
			}
		}
		result = h_pos * depth;

		return result;
	}
}
