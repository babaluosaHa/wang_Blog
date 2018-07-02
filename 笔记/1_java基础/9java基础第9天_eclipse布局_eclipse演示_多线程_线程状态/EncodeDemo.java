class EncodeDemo 
{
	public static void main(String[] args) 
	{
		String str="a中b";

		//编码
		byte[] bytes=str.getBytes("GBK");
		System.out.println(bytes.length);

		String newStr=new String(bytes,"GBK");
		System.out.println(newStr);

		byte[] big5={-92,92};
		System.out.println(new String(big5,"big5"));

		System.out.println(new String(new String(new byte[]{-80,22},"big5"));
	}
}
