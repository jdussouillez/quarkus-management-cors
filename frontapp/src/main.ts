import {platformBrowserDynamic} from "@angular/platform-browser-dynamic";
import {AppModule} from "./app/app.module";

function runAngular(): void {
    platformBrowserDynamic().bootstrapModule(AppModule)
        .catch(error => console.error(error));
}

runAngular();
