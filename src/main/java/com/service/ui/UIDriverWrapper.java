package com.service.ui;


public interface UIDriverWrapper
{

	boolean init();

	void close();

	boolean click(Object o);

	boolean type(Object o, String text);

}
