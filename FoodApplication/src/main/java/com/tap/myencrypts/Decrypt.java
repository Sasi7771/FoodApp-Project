package com.tap.myencrypts;

public class Decrypt 
{
	public static String decrypt(String str)
	{
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			int x=c;
			x=x-2;
			c=(char)x;
			sb.append(c);
		}
		return sb.toString();
	}
}