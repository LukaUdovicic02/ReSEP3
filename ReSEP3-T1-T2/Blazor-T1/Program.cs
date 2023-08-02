using System;
using System.Net.Http;
using Blazor_T1;
using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;

using Microsoft.Extensions.DependencyInjection;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
builder.RootComponents.Add<App>("#app");
builder.RootComponents.Add<HeadOutlet>("head::after");

builder.Services.AddScoped(sp => new HttpClient {BaseAddress = new Uri(builder.HostEnvironment.BaseAddress)});
builder.Services.AddScoped<ILoginService, LoginHttpClient>();
builder.Services.AddScoped<IExerciseService, ExerciseHttpClient>();
builder.Services.AddScoped<IRegisterService, RegisterHttpClient>();
builder.Services.AddScoped<IWorkoutPlanService, WorkoutPlanHttpClient>();

await builder.Build().RunAsync();