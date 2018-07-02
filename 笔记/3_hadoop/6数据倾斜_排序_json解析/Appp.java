package com.it18zhang.hadoop.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

/**
 */
public class Appp {
	public static void main(String[] args) throws Exception {
		args = new String[]{"file:///d:/mr/wc/1.txt" , "file:///d:/mr/wc/out"} ;
		if(args == null || args.length < 2){
			throw new Exception("参数不足,需要两个参数!") ;
		}

		Configuration conf = new Configuration() ;
		conf.set("fs.defaultFS" , "file:///");
		FileSystem fs = FileSystem.get(conf) ;

		//递归删除输出目录
		fs.delete(new Path(args[1]),true) ;

		//创建job
		Job job = Job.getInstance(conf)	;
		job.setJobName("word_count_app");
		job.setJarByClass(Appp.class);

		//设置切片大小
//		job.getConfiguration().set("mapreduce.input.fileinputformat.split.minsize" , "10");
//		job.getConfiguration().set("mapreduce.input.fileinputformat.split.maxsize" , "10");

		FileInputFormat.setMinInputSplitSize(job,10);
		FileInputFormat.setMaxInputSplitSize(job,10);

		//设置输入格式类
		job.setInputFormatClass(TextInputFormat.class);
		//设置输入格式类
		job.setOutputFormatClass(TextOutputFormat.class);

		//添加输入路径
		FileInputFormat.addInputPath(job,new Path(args[0]));
		//设置输出路径
		FileOutputFormat.setOutputPath(job , new Path(args[1]));

		//设置mapper类和reducer类
		job.setMapperClass(WordCountMapper00.class);
		job.setReducerClass(WordCountReducer00.class);
		//设置合成器,做map端预聚合
		job.setCombinerClass(WordCountCombiner00.class);

		//设置输出的kv类型
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(IntWritable.class);

		//设置reduce个数
		job.setNumReduceTasks(2);

		//开始作业
		job.waitForCompletion(true) ;
	}
}
