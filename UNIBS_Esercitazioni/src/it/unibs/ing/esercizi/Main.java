package it.unibs.ing.esercizi;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		IntStream.range(1, 11)
		.filter(t -> t%2!=0)
		.map(i->i*i)
		.forEach((i)->System.out.println(i));

		LongStream serie =Stream
				.iterate(new long[] {0, 1},f -> new long[] {f[1], f[1]*2+f[0]*3})
	             .mapToLong(f->f[0]);
		
		serie
		.limit(11)
		.forEach(System.out::println);
	}

}
