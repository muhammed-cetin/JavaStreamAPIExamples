package arraynumberexample;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayNumberExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 7, 8, 9, 5, 2, 36, 4, 78, 222, 24, 9);

        sumOfAllNumbers(list);

        averageOfAllNumbers(list);

        getNumbersSquareAndFilterAndAverage(list);

        getNumbersEvenAndOddSeparately(list);

        getNumbersStartingWith2(list);

        getDuplicateNumbers(list);

        getMaxAndMinValueInList(list);

        sortNumbersByASCandDESC(list);

        getFirst4ElementsAndSum(list);

        getSumAfter5Numbers(list);

        getSumElements4to8(list);

        getCubeOfEachNumber(list);

    }

    private static void getCubeOfEachNumber(List<Integer> integerlist) {
        List<Integer> cubes = integerlist.stream()
                .map(number -> number * number * number)
                .collect(Collectors.toList());

        System.out.println("Example 12 Cubes : " + cubes);

        // Example 12 Cubes : [1, 343, 512, 729, 125, 8, 46656, 64, 474552, 10941048, 13824, 729]
    }



    private static void getSumElements4to8(List<Integer> integerList) {
        List<Integer> between4and8 = integerList.stream()
                .skip(4) // 5. elemandan başla (0'dan başlayarak sayılır, bu nedenle 4)
                .limit(5) // 4. elemandan itibaren 5 eleman al
                .collect(Collectors.toList());
        System.out.println("Example 11 : between4and8 : " + between4and8);

        int between4and8sum = integerList.stream()
                .skip(4)
                .limit(5)
                .reduce((a, b) -> a + b)
                .get();
        System.out.println("Example 11 : between4and8sum : " + between4and8sum);
    }

    private static void getSumAfter5Numbers(List<Integer> list) {
        int sum1 = list.stream().skip(5).reduce((a, b) -> a + b).get();
        System.out.println("Example 10 : Sum after first 5 elements skip: " + sum1);

        // Example 10 : Sum after first 5 elements skip: 375
    }

    private static void getFirst4ElementsAndSum(List<Integer> integerList) {
        List<Integer> first4elements = integerList.stream()
                .limit(4)
                .collect(Collectors.toList());

        // Example 9 : first4elements: [1, 7, 8, 9]
        System.out.println("Example 9 : first4elements: " + first4elements);

        int first4sum = integerList.stream()
                .limit(4).reduce((a, b) -> a + b)
                .get();

        System.out.println("Example 9 : first4elements: sum:  " + first4sum);

        int first4sumSecond = integerList.stream()
                .limit(4).reduce(0, Integer::sum);

        System.out.println("Example 9 : first4elements: second sum:  " + first4sumSecond);
    }

    private static void sortNumbersByASCandDESC(List<Integer> integerList) {
        List<Integer> asc_order = integerList.stream()
                .sorted() // Stream içindeki elemanları küçükten büyüğe doğal sıralama düzenine göre sıralar.
                .collect(Collectors.toList()); // Sıralanmış elemanları bir List<Integer> koleksiyonuna toplar.

        System.out.println("Example 8 : ASC Order: " + asc_order);

        List<Integer> desc_order = integerList.stream()
                .sorted(Collections.reverseOrder()) // karşılaştırma sırasını tersine çevirir ve böylece elemanlar büyükten küçüğe doğru sıralanır.
                .collect(Collectors.toList());

        System.out.println("Example 8 : DESC Order: " + desc_order);
    }

    private static void getMaxAndMinValueInList(List<Integer> integerList) {
        int maxNumber = integerList.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .get();

        System.out.println("Example 7 > maxNumber : " + maxNumber);

        int maxNumber1 = integerList.stream()
                .max(Comparator.naturalOrder())
                .get();
        System.out.println("Example 7 > maxNumber1 : " + maxNumber1);

        int minNumber = integerList.stream()
                .min(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println("Example 7 > minNumber : " + minNumber);

        int minNumber1 = integerList.stream()
                .min(Comparator.naturalOrder())
                .get();

        System.out.println("Example 7 > minNumber1 : " + minNumber1);

        // Comparator.naturalOrder() varsayılan olarak doğal sıralama düzenini kullanır. (küçükten büyüğe)
        /*
            max(Comparator.comparing(Integer::valueOf)): Bu, Stream içindeki elemanların maksimum değerini bulmaya çalışır.
            Comparator.comparing metodu, karşılaştırma için bir Comparator oluşturur ve Integer::valueOf ifadesi, elemanların
            Integer türüne dönüştürülmesini sağlar. Böylece, elemanlar Integer olarak karşılaştırılır ve en büyük olan bulunur.
         */
    }

    private static void getDuplicateNumbers(List<Integer> integerList) {

        /*
            filter(number -> Collections.frequency(integerList, number) > 1): her elemanın frekansını kontrol eder.
            Collections.frequency metodu, belirli bir öğenin koleksiyon içinde kaç kez geçtiğini sayar. Bu durumda,
            frekansı 1'den büyük olanları (tekrar edenleri) filtreler.
         */
        Set<Integer> duplicates = integerList.stream()
                .filter(number -> Collections.frequency(integerList, number) > 1)
                .collect(Collectors.toSet());

        System.out.println("Example 6 : First way : duplicates: " + duplicates);
    }

    private static void getNumbersStartingWith2(List<Integer> integerList) {

        List<Integer> startsWith2 = integerList.stream()
                .map(number -> String.valueOf(number)) // Sayıları String'e dönüştür
                .filter(number -> number.startsWith("2")) // "2" ile başlayanları filtrele
                .map(Integer::valueOf) // String'i tekrar Integer'a dönüştür
                .collect(Collectors.toList()); // sonuçları bir List koleksiyonuna toplar.

        System.out.println("Example 5 : startsWith2: " + startsWith2);
    }

    private static void getNumbersEvenAndOddSeparately(List<Integer> integerList) {

        List<Integer> evens = integerList.stream()
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Example 4 : evens: " + evens);

        List<Integer> odds = integerList.stream()
                .filter(number -> number % 2 != 0)
                .collect(Collectors.toList());

        System.out.println("Example 4 : odds: " + odds);

        Map<Boolean, List<Integer>> evenOddMap = integerList.stream()
                .collect(Collectors
                        .partitioningBy(number -> number % 2 == 0));

        Map<Boolean, List<Integer>> evenOddMap1 = integerList.stream()
                .collect(Collectors.groupingBy(number -> number % 2 != 0));

        /*
            groupingBy sonucunda her grup bir liste içinde bulunurken, partitioningBy sadece iki grupta toplar: true ve false.
         */
    }

    private static void getNumbersSquareAndFilterAndAverage(List<Integer> integerList) {

        double average1 = integerList.stream()
                .map(a -> a * a) //  Stream'in her elemanının karesini alır.
                .filter(number -> number > 100) // 100'den büyük olanları filtrele
                .mapToInt(a -> a)// Stream'i IntStream'e dönüştürür.
                .average()// Ortalamayı hesapla ve bir OptionalDouble döndür
                .orElse(0); // Eğer ortalamayı alamazsak varsayılan olarak 0 kullan

        System.out.println("Example 3 : average : " + average1);
    }

    private static void averageOfAllNumbers(List<Integer> integerList) {

        double average = integerList.stream() // Liste üzerinde bir Stream oluşturulur.
                .mapToInt(a -> a) // Stream'i IntStream'e dönüştürür.
                .average() // Ortalamayı hesapla ve bir OptionalDouble döndür
                .orElse(0); // Eğer ortalamayı alamazsak varsayılan olarak 0 kullan

        System.out.println("Example 2 : average : " + average);

        // Example 2 : average : 33.75
    }

    private static void sumOfAllNumbers(List<Integer> integerList) {

        // Optional<Integer> sum = integerList.stream().reduce(Integer::sum);  <-> can also be used like this
        Optional<Integer> sum = integerList.stream().reduce((a, b) -> a + b);

        // isPresent() yöntemi, Optional'da bir değer olup olmadığını kontrol eder.
        // Eğer true değerini döndürürse, değer get() yöntemi kullanılarak alınabilir ve işlenebilir.
        if (sum.isPresent()) {
            System.out.println("Example 1 : First way : sum : " + sum.get());
        } else {
            System.out.println("Total not found");
        }

        int sumSecondWay = integerList.stream().reduce(0, Integer::sum);
        System.out.println("Example 1 : Second way : sum : " + sumSecondWay);


        // Example 1 : First way : sum : 405
        // Example 1 : Second way : sum :  405
    }
}
