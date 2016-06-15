package com.gsmayya.cups.parser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Queue;
import java.util.Vector;

public class ParseFunctions {

    Class actualClass = null;

    Queue<Object> parsedObject = null;

    public ParseFunctions(Class<? extends Object> impl) {
		actualClass = impl;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ParseFunctions parser = new ParseFunctions(ActualFunctions.class);
		parser.parseString("");

	}

    // TODO: This is where the parser will come in.
    public void parseString(String str) {
		Vector<Object> arguments = new Vector<Object>();

		HashMap<String, String> argument = new HashMap<String, String>();
		argument.put("10", "int");
		arguments.add(argument);
		HashMap<String, String> argument2 = new HashMap<String, String>();
		argument2.put("20", "int");
		arguments.add(argument2);

		HashMap<String, Object> row = new HashMap<String, Object>();
		row.put("op", "times");
		row.put("args", arguments);
		parsedObject.add(row);
	}

    public void execute() {

		Iterator<Object> itr = parsedObject.iterator();
		while (itr.hasNext()) {
			HashMap<String, Object> row = (HashMap<String, Object>) itr.next();
			String function = (String) row.get("op");
			Vector<Object> args = (Vector<Object>) row.get("args");

			if (function == "times") {

			}

		}
	}

}
