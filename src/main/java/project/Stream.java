    package project;
    import java.util.stream.IntStream;
    
    class Stream {
    
  public static void main(String[] args) {
        // Create a stream of integers from 1 to 10
       IntStream  intStream = IntStream.rangeClosed(1, 10);
        
        // Print each integer in the stream
        intStream.forEach(System.out::println);
        
        // Create a stream of strings
        java.util.stream.Stream<String> stringStream = java.util.stream.Stream.of("Hello", "World", "Java", "Streams");
        
        // Print each string in the stream
        stringStream.forEach(System.out::println);
  }   
    }