import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LayoutDefaultComponent } from '@core/layout/default/default.component';
import { Exception404Component } from '@shared/components/error/404.component';
import { Exception403Component } from '@shared/components/error/403.component';
import { Exception500Component } from '@shared/components/error/500.component';
import { HomeComponent } from './modules/home/components/home.component';
import { ExceptionOfflineComponent } from '@shared/components/error/offline.component';
import { ExceptionInitComponent } from '@shared/components/error/init.component';

export const routes: Routes = [{
  path: '',
  redirectTo: 'home',
  pathMatch: 'full',
}, {
  path: '',
  component: LayoutDefaultComponent,
  children: [{
    path: 'home',
    component: HomeComponent,
    data: {
      title: 'Home',
    },
  }],
}, {
  path: 'error/403',
  component: Exception403Component,
}, {
  path: 'error/404',
  component: Exception404Component,
}, {
  path: 'error/500',
  component: Exception500Component,
}, {
  path: 'error/offline',
  component: ExceptionOfflineComponent,
}, {
  path: 'error/init',
  component: ExceptionInitComponent,
}, {
  path: '**',
  component: Exception404Component,
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
