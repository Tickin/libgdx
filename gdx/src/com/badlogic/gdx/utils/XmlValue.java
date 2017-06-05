package com.badlogic.gdx.utils;

import com.badlogic.gdx.utils.ObjectMap.Entry;

public class XmlValue{
	private final String name;
	private ObjectMap<String, String> attributes;
	private Array<XmlValue> children;
	private String text;
	private XmlValue parent;

	public XmlValue (String name, XmlValue parent) {
		this.name = name;
		this.parent = parent;
	}

	public String getName () {
		return name;
	}

	public ObjectMap<String, String> getAttributes () {
		return attributes;
	}

	/** @throws GdxRuntimeException if the attribute was not found. */
	public String getAttribute (String name) {
		if (attributes == null) throw new GdxRuntimeException("XmlValue " + this.name + " doesn't have attribute: " + name);
		String value = attributes.get(name);
		if (value == null) throw new GdxRuntimeException("XmlValue " + this.name + " doesn't have attribute: " + name);
		return value;
	}

	public String getAttribute (String name, String defaultValue) {
		if (attributes == null) return defaultValue;
		String value = attributes.get(name);
		if (value == null) return defaultValue;
		return value;
	}

	public void setAttribute (String name, String value) {
		if (attributes == null) attributes = new ObjectMap(8);
		attributes.put(name, value);
	}

	public int getChildCount () {
		if (children == null) return 0;
		return children.size;
	}

	/** @throws GdxRuntimeException if the XmlValue has no children. */
	public XmlValue getChild (int index) {
		if (children == null) throw new GdxRuntimeException("XmlValue has no children: " + name);
		return children.get(index);
	}

	public void addChild (XmlValue XmlValue) {
		if (children == null) children = new Array(8);
		children.add(XmlValue);
	}

	public String getText () {
		return text;
	}

	public void setText (String text) {
		this.text = text;
	}

	public void removeChild (int index) {
		if (children != null) children.removeIndex(index);
	}

	public void removeChild (XmlValue child) {
		if (children != null) children.removeValue(child, true);
	}

	public void remove () {
		parent.removeChild(this);
	}

	public XmlValue getParent () {
		return parent;
	}

	public String toString () {
		return toString("");
	}

	public String toString (String indent) {
		StringBuilder buffer = new StringBuilder(128);
		buffer.append(indent);
		buffer.append('<');
		buffer.append(name);
		if (attributes != null) {
			for (Entry<String, String> entry : attributes.entries()) {
				buffer.append(' ');
				buffer.append(entry.key);
				buffer.append("=\"");
				buffer.append(entry.value);
				buffer.append('\"');
			}
		}
		if (children == null && (text == null || text.length() == 0))
			buffer.append("/>");
		else {
			buffer.append(">\n");
			String childIndent = indent + '\t';
			if (text != null && text.length() > 0) {
				buffer.append(childIndent);
				buffer.append(text);
				buffer.append('\n');
			}
			if (children != null) {
				for (XmlValue child : children) {
					buffer.append(child.toString(childIndent));
					buffer.append('\n');
				}
			}
			buffer.append(indent);
			buffer.append("</");
			buffer.append(name);
			buffer.append('>');
		}
		return buffer.toString();
	}

	/** @param name the name of the child {@link XmlValue}
	 * @return the first child having the given name or null, does not recurse */
	public XmlValue getChildByName (String name) {
		if (children == null) return null;
		for (int i = 0; i < children.size; i++) {
			XmlValue XmlValue = children.get(i);
			if (XmlValue.name.equals(name)) return XmlValue;
		}
		return null;
	}

	/** @param name the name of the child {@link XmlValue}
	 * @return the first child having the given name or null, recurses */
	public XmlValue getChildByNameRecursive (String name) {
		if (children == null) return null;
		for (int i = 0; i < children.size; i++) {
			XmlValue XmlValue = children.get(i);
			if (XmlValue.name.equals(name)) return XmlValue;
			XmlValue found = XmlValue.getChildByNameRecursive(name);
			if (found != null) return found;
		}
		return null;
	}

	/** @param name the name of the children
	 * @return the children with the given name or an empty {@link Array} */
	public Array<XmlValue> getChildrenByName (String name) {
		Array<XmlValue> result = new Array<XmlValue>();
		if (children == null) return result;
		for (int i = 0; i < children.size; i++) {
			XmlValue child = children.get(i);
			if (child.name.equals(name)) result.add(child);
		}
		return result;
	}

	/** @param name the name of the children
	 * @return the children with the given name or an empty {@link Array} */
	public Array<XmlValue> getChildrenByNameRecursively (String name) {
		Array<XmlValue> result = new Array<XmlValue>();
		getChildrenByNameRecursively(name, result);
		return result;
	}

	private void getChildrenByNameRecursively (String name, Array<XmlValue> result) {
		if (children == null) return;
		for (int i = 0; i < children.size; i++) {
			XmlValue child = children.get(i);
			if (child.name.equals(name)) result.add(child);
			child.getChildrenByNameRecursively(name, result);
		}
	}

	/** @throws GdxRuntimeException if the attribute was not found. */
	public float getFloatAttribute (String name) {
		return Float.parseFloat(getAttribute(name));
	}

	public float getFloatAttribute (String name, float defaultValue) {
		String value = getAttribute(name, null);
		if (value == null) return defaultValue;
		return Float.parseFloat(value);
	}

	/** @throws GdxRuntimeException if the attribute was not found. */
	public int getIntAttribute (String name) {
		return Integer.parseInt(getAttribute(name));
	}

	public int getIntAttribute (String name, int defaultValue) {
		String value = getAttribute(name, null);
		if (value == null) return defaultValue;
		return Integer.parseInt(value);
	}

	/** @throws GdxRuntimeException if the attribute was not found. */
	public boolean getBooleanAttribute (String name) {
		return Boolean.parseBoolean(getAttribute(name));
	}

	public boolean getBooleanAttribute (String name, boolean defaultValue) {
		String value = getAttribute(name, null);
		if (value == null) return defaultValue;
		return Boolean.parseBoolean(value);
	}

	/** Returns the attribute value with the specified name, or if no attribute is found, the text of a child with the name.
	 * @throws GdxRuntimeException if no attribute or child was not found. */
	public String get (String name) {
		String value = get(name, null);
		if (value == null) throw new GdxRuntimeException("XmlValue " + this.name + " doesn't have attribute or child: " + name);
		return value;
	}

	/** Returns the attribute value with the specified name, or if no attribute is found, the text of a child with the name.
	 * @throws GdxRuntimeException if no attribute or child was not found. */
	public String get (String name, String defaultValue) {
		if (attributes != null) {
			String value = attributes.get(name);
			if (value != null) return value;
		}
		XmlValue child = getChildByName(name);
		if (child == null) return defaultValue;
		String value = child.getText();
		if (value == null) return defaultValue;
		return value;
	}

	/** Returns the attribute value with the specified name, or if no attribute is found, the text of a child with the name.
	 * @throws GdxRuntimeException if no attribute or child was not found. */
	public int getInt (String name) {
		String value = get(name, null);
		if (value == null) throw new GdxRuntimeException("XmlValue " + this.name + " doesn't have attribute or child: " + name);
		return Integer.parseInt(value);
	}

	/** Returns the attribute value with the specified name, or if no attribute is found, the text of a child with the name.
	 * @throws GdxRuntimeException if no attribute or child was not found. */
	public int getInt (String name, int defaultValue) {
		String value = get(name, null);
		if (value == null) return defaultValue;
		return Integer.parseInt(value);
	}

	/** Returns the attribute value with the specified name, or if no attribute is found, the text of a child with the name.
	 * @throws GdxRuntimeException if no attribute or child was not found. */
	public float getFloat (String name) {
		String value = get(name, null);
		if (value == null) throw new GdxRuntimeException("XmlValue " + this.name + " doesn't have attribute or child: " + name);
		return Float.parseFloat(value);
	}

	/** Returns the attribute value with the specified name, or if no attribute is found, the text of a child with the name.
	 * @throws GdxRuntimeException if no attribute or child was not found. */
	public float getFloat (String name, float defaultValue) {
		String value = get(name, null);
		if (value == null) return defaultValue;
		return Float.parseFloat(value);
	}

	/** Returns the attribute value with the specified name, or if no attribute is found, the text of a child with the name.
	 * @throws GdxRuntimeException if no attribute or child was not found. */
	public boolean getBoolean (String name) {
		String value = get(name, null);
		if (value == null) throw new GdxRuntimeException("XmlValue " + this.name + " doesn't have attribute or child: " + name);
		return Boolean.parseBoolean(value);
	}

	/** Returns the attribute value with the specified name, or if no attribute is found, the text of a child with the name.
	 * @throws GdxRuntimeException if no attribute or child was not found. */
	public boolean getBoolean (String name, boolean defaultValue) {
		String value = get(name, null);
		if (value == null) return defaultValue;
		return Boolean.parseBoolean(value);
	}
}