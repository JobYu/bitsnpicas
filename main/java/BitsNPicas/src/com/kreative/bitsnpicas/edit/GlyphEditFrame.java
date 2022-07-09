package com.kreative.bitsnpicas.edit;

import javax.swing.JFrame;
import com.kreative.bitsnpicas.Font;
import com.kreative.bitsnpicas.FontGlyph;
import com.kreative.unicode.data.NameResolver;

public class GlyphEditFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private final GlyphEditPanel<?> panel;
	private final GlyphEditMenuBar mb;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GlyphEditFrame(Font<?> font, FontGlyph glyph, int codePoint, GlyphList gl, SaveManager sm) {
		this.panel = new GlyphEditPanel(font, glyph, gl);
		this.mb = new GlyphEditMenuBar(this, sm, font, panel.glyphComponent);
		setTitle(getTitle(font, codePoint));
		setJMenuBar(mb);
		setContentPane(panel);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static String getTitle(Font<?> font, int codePoint) {
		return characterName(codePoint) + " from " + font.toString();
	}
	
	private static String characterName(int cp) {
		String h = Integer.toHexString(cp).toUpperCase();
		while (h.length() < 4) h = "0" + h;
		String n = NameResolver.instance(cp).getName(cp);
		return "U+" + h + " " + n;
	}
}
