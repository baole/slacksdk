package com.anttek.tool;

public class Type {
    public String _type;
    public int _kind;
    public int targetKind;
    public boolean isPrimative = false;

    public String in;
    public String name;

    Type(String type, int kind) {
        this._type = type;
        this._kind = kind;
    }

    public String getType() {
        return _type;
    }

    public String getFullType() {
        if (_kind == CodeGeneratorV2.TYPE_OBJECT) {
            return _type;
        } else {
            return String.format("ArrayList<%s>", makeClassName(_type));
        }
    }

    public String makeClassName(String action) {
        try {
            String name = action.substring(0, 1).toUpperCase() + action.substring(1, action.length());

            int _index = name.indexOf("_");
            while (_index >= 0) {
                name = name.substring(0, _index) + name.substring(_index + 1, _index + 2).toUpperCase() + name.substring(_index + 2, name.length());
                _index = name.indexOf("_");
            }

            if (CodeGeneratorV2.isNumeric(name)) {
                name = "_" + name;
            }

            return name;
        } catch (Throwable e) {
            System.err.println("Error: Cannot formalize classname for " + action);
            return action;
        }
    }


    public int getKind() {
        return _kind;
    }


}
