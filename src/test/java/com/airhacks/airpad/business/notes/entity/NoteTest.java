package com.airhacks.airpad.business.notes.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adam-bien.com
 */
public class NoteTest {

    @Test
    public void matches() {
        Note cut = new Note("a");
        cut.contentProperty().set("b");
        assertTrue(cut.matches("a"));
        assertTrue(cut.matches("b"));
        assertTrue(cut.matches(" "));
    }

    @Test
    public void matchesWithoutContent() {
        Note cut = new Note("a");
        assertTrue(cut.matches("a"));
        assertFalse(cut.matches("b"));
        assertFalse(cut.matches("c"));
    }

    @Test
    public void dirtyDetection() {
        Note cut = new Note("a");
        assertTrue(cut.isDirty());
        cut.synced();
        assertFalse(cut.isDirty());

        cut.contentProperty().set("new content");
        assertTrue(cut.isDirty());
        cut.synced();
        assertFalse(cut.isDirty());

        cut.titleProperty().set("new content");
        assertTrue(cut.isDirty());
        cut.synced();
        assertFalse(cut.isDirty());

    }
}
