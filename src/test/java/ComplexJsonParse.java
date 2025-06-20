import Files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
    public static void main(String[] args ){
        JsonPath js = new JsonPath(Payload.coursePrice());
        //Print No of courses returned by API
        int count = js.getInt("cources.size()");
        System.out.println(count);

        //Print Purchase Amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        //Print Title of the first course
        String title1 = js.getString("cources[0].title");
        System.out.println(title1);

        //Print All course titles and their respective Prices
        int sum =0;
        for(int i=0;i<count;i++){
            String titleOfCourse = js.getString("cources["+i+"].title");
            int priceOfCourse = js.getInt("cources["+i+"].price");
            int copiesSold = js.getInt("cources["+i+"].copies");
            System.out.println(titleOfCourse+": "+priceOfCourse);
            sum = sum+priceOfCourse*copiesSold;
        }
        System.out.println(sum);
        //Verify if Sum of all Course prices matches with Purchase Amount
        if(sum==purchaseAmount){
            System.out.println("Matched");
        }else{
            System.out.println("Not_Matched");
        }

        for(int i=0;i<count;i++) {
            String titleOfCourse = js.getString("cources["+i+"].title");
            if(titleOfCourse.equalsIgnoreCase("Python")) {
                //Print no of copies sold by RPA/Python Course
                int copiesSold = js.getInt("cources["+i+"].copies");
                System.out.println(copiesSold);
            }
        }
    }
}
