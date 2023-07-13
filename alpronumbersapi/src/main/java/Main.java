import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("Please enter the number you'd like to know some trivia about: ");
        Scanner scan = new Scanner(System.in);
        var number = scan.nextInt();

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://numbersapi.com/" + number)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if(!response.isSuccessful()) {
                    throw new IOException("Error Code: " + response);
                } else {
                    System.out.println(response.body().string());
                }
            }
        });
    }
}
