package com.it18zhang.hadoop.mr;

import com.it18zhang.hadoop.util.DebugTool;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * Mapper
 */
public class WordCountMapper00 extends Mapper<LongWritable, Text, Text, IntWritable> {
	public WordCountMapper00(){
		DebugTool.sendInfo("s101" , 8888 , this, "new Mapper()");

	}

	protected void setup(Context context) throws IOException, InterruptedException {
		DebugTool.sendInfo("s101", 8888, this, "Mapper.setup()");
	}

	protected void cleanup(Context context) throws IOException, InterruptedException {
		DebugTool.sendInfo("s101", 8888, this, "Mapper.cleanup()");
	}

	/**
	 * key : 行首偏移量，字节数，意义不大。
	 * value ： 一行文本
	 */
	protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		DebugTool.sendInfo("s101", 8888, this, "Mapper.map() : " + value);
		//
		String line = value.toString() ;
		String[] arr = line.split(" ");

		Text keyOut = new Text() ;
		IntWritable valueOut = new IntWritable(1) ;
		for(String word : arr){
			keyOut.set(word);
			context.write(keyOut,valueOut);
		}
	}
}
