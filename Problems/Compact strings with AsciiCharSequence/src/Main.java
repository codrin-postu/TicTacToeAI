import java.nio.charset.StandardCharsets;
import java.util.*;

class AsciiCharSequence /* extends/implements */ implements CharSequence {

    byte[] chars;

    public AsciiCharSequence(byte[] chars) {
        this.chars = chars;
    }

    @Override
    public int length() {
        return chars.length;
    }

    @Override
    public char charAt(int i) {
        return (char) chars[i];
    }

    @Override
    public CharSequence subSequence(int start, int end) throws IndexOutOfBoundsException {
        if (start < 0 || end < 0 || start > end || end > chars.length) {
            throw new IndexOutOfBoundsException();
        }

        byte[] subSeq = new byte[end - start];
        int subSeqPosition = 0;
        for (int i = start; i < end; i++) {
            subSeq[subSeqPosition++] = chars[i];
        }

        AsciiCharSequence subSequence = new AsciiCharSequence(subSeq);

        return subSequence;
    }
    // implementation


    @Override
    public String toString() {
        return new String(chars, StandardCharsets.UTF_8);
    }
}