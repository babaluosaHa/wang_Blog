package com.it18zhang.hadoop.mr;

import com.it18zhang.hadoop.util.DebugTool;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * combiner
 */
public class WordCountCombiner00 extends Reducer<Text, IntWritable, Text, IntWritable> {
	public WordCountCombiner00(){
		DebugTool.sendInfo("s101", 8888, this, "new Combiner()");
	}
	/**
	 * key : word
	 * values : 该key下聚合的value
	 */
	protected void reduce(Text key, Iterable<IntWritable> values, Context context) throws IOException, InterruptedException {
		int count = 0 ;
		for(IntWritable iw : values){
			count = count + iw.get() ;
		}
		context.write(key , new IntWritable(count));
	}
}
