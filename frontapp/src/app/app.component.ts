import {Component} from "@angular/core";

import {HelloResourceService} from "./modules/api/openapi-client";

@Component({
    selector: "app-root",
    templateUrl: "./app.component.html",
    styleUrl: "./app.component.css"
})
export class AppComponent {

    protected locale = "en";
    
    protected helloResult = "";
    
    protected helloValue = "";

    public constructor(private readonly helloResourceService: HelloResourceService) {
    }

    protected getHello(): void {
        this.helloResourceService.hello({locale: this.locale})
            .subscribe(result => this.helloResult = result);
    }

    protected addHello(): void {
        this.helloResourceService.addHello({locale: this.locale, body: this.helloValue})
            .subscribe(() => {
                this.helloValue = "";
                this.getHello();
            });
    }
}
