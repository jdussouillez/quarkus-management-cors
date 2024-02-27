import {Component} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {RouterOutlet} from "@angular/router";

const HELLO_API_URL = "http://localhost:4200/api/hello";

@Component({
    selector: "app-root",
    standalone: true,
    imports: [
        CommonModule,
        FormsModule,
        RouterOutlet,
        HttpClientModule
    ],
    templateUrl: "./app.component.html",
    styleUrl: "./app.component.css"
})
export class AppComponent {

    protected locale = "en";
    
    protected helloResult = "";
    
    protected helloValue = "";

    public constructor(private readonly httpClient: HttpClient) {
    }

    protected getHello(): void {
        this.httpClient.get(HELLO_API_URL + "/" + this.locale, {responseType: "text"})
            .subscribe(result => this.helloResult = result);
    }

    protected addHello(): void {
        this.httpClient.post(HELLO_API_URL + "/" + this.locale, this.helloValue, {responseType: "text"})
            .subscribe(() => {
                this.helloValue = "";
                this.getHello();
            });
    }
}
