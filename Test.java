class Test {
  public static void go() {
    String s = "";
    while(s.equals("")) {
      s = Input.strIn().replaceAll(" ", "");
    }
    System.out.println("You entered: " + s);
  }
}