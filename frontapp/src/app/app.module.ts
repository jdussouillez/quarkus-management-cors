import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {RouterOutlet} from "@angular/router";
import {BrowserModule}  from "@angular/platform-browser";

import {frontappApiModule, Configuration, ConfigurationParameters} from "./modules/api/openapi-client";
import {AppComponent} from "./app.component";

export function apiConfigFactory(): Configuration {
    const params: ConfigurationParameters = {
        basePath: "http://localhost:4200"
    };
    return new Configuration(params);
}

@NgModule({
    declarations: [
        AppComponent
    ],
    imports: [
        BrowserModule,
        CommonModule,
        FormsModule,
        RouterOutlet,
        HttpClientModule,
        frontappApiModule.forRoot(apiConfigFactory)
    ],
    providers: [
    ],
    exports: [
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
