class ExceptionDemo 
{
	public static void main(String[] args) 
	{
		Person p =new Person();
		try{
			p.setAge(-100);
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("over!!");
	}
}

class Person
{
	private int age;
	public int getAge(){
		return age;
	}

	public void setAge(int age) throws AgeTooSmallException,AgeTooBigException{
		if(age<0){
			throw new AgeTooSmallException("年龄过小，不合法！");
		if(age>2000){
			throw new AgeTooBiglException("年龄过大，不合法！");
		}
		this.age=age;
	}
}

//自定义异常
class AgeTooSmallException extends Exception
{
	public AgeTooSmallException(){
	}
	public AgeTooSmallException(String msg){
		super(msg);
	}
}

class AgeTooBigException extends Exception
{
	public AgeTooBigException(){
	}
	public AgeTooBigException(String msg){
		super(msg);
	}
}