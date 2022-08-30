package io.github.cyklon73.cytils.edsf;

public enum CharSet {
    //bit 8:
    //  0 alphabet
    //  1 number
    //bit 9:
    //  0 klein buchstabe
    //  1 groß buchstabe

    //char,     123456789
    a('a', ""),
    b('b', ""),
    c('c', ""),
    d('d', ""),
    e('e', ""),
    f('f', ""),
    g('g', ""),
    h('h', ""),
    i('i', ""),
    j('j', ""),
    k('k', ""),
    l('l', ""),
    m('m', ""),
    n('n', ""),
    o('o', ""),
    p('p', ""),
    q('q', ""),
    r('r', ""),
    s('s', ""),
    t('t', ""),
    u('u', ""),
    v('v', ""),
    w('w', ""),
    x('x', ""),
    y('y', ""),
    z('z', ""),

    A('A', ""),
    B('B', ""),
    C('C', ""),
    D('D', ""),
    E('E', ""),
    F('F', ""),
    G('G', ""),
    H('H', ""),
    I('I', ""),
    J('J', ""),
    K('K', ""),
    L('L', ""),
    M('M', ""),
    N('N', ""),
    O('O', ""),
    P('P', ""),
    Q('Q', ""),
    R('R', ""),
    S('S', ""),
    T('T', ""),
    U('U', ""),
    V('V', ""),
    W('W', ""),
    X('X', ""),
    Y('Y', ""),
    Z('Z', "");

    private final char character;
    private final String bytes;

    CharSet(char c, String bytes) {
        this.character = c;
        this.bytes = bytes;
    }

    public static CharSet getByBits(String bits) {
        for (CharSet v:values()) {
            if (v.bytes.equals(bits)) {
                return v;
            }
        }
        return null;
    }

    public static CharSet getByChar(char c) {
        for (CharSet v:values()) {
            if (v.character==c) {
                return v;
            }
        }
        return null;
    }

    public String getBits() {
        return bytes;
    }

    public char getChar() {
        return character;
    }
}