package ru.job4j.Test.Parser;

public class TestStaX {

//    public static void main(String[] args) {
//
//        XMLInputFactory factory = XMLInputFactory.newInstance();
////        XMLStreamReader r = factory.createXMLStreamReader( ));
//        try {
//            int event = r.getEventType();
//            while (true) {
//                switch (event) {
//                    case XMLStreamConstants.START_DOCUMENT:
//                        out.println("Start Document.");
//                        break;
//                    case XMLStreamConstants.START_ELEMENT:
//                        out.println("Start Element: " + r.getName());
//                        for(int i = 0, n = r.getAttributeCount(); i < n; ++i)
//                            out.println("Attribute: " + r.getAttributeName(i)
//                                    + "=" + r.getAttributeValue(i));
//
//                        break;
//                    case XMLStreamConstants.CHARACTERS:
//                        if (r.isWhiteSpace())
//                            break;
//
//                        out.println("Text: " + r.getText());
//                        break;
//                    case XMLStreamConstants.END_ELEMENT:
//                        out.println("End Element:" + r.getName());
//                        break;
//                    case XMLStreamConstants.END_DOCUMENT:
//                        out.println("End Document.");
//                        break;
//                }
//
//                if (!r.hasNext())
//                    break;
//
//                event = r.next();
//            }
//        } finally {
//            r.close();
//        }
//    }
}
