
using Domain.gRPClient;
using Domain.gRPClient.RepoInterfaces;
using Domain.Logic;
using Domain.Logic.LogicInterfaces;
using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddCors(options =>
{
    options.AddPolicy("AllowAllOrigins", builder =>
    {
        builder.AllowAnyOrigin();
        builder.AllowAnyHeader();
        builder.AllowAnyMethod();
    });
});

builder.Services.AddScoped<IRepoLogin, LoginGrpc>();
builder.Services.AddScoped<IUserLogic ,UserLogic>();

builder.Services.AddScoped<IRepoRegister, RegisterGrpc>();

builder.Services.AddScoped<IRepoWorkoutPlan, WorkoutPlanGrpc>();
builder.Services.AddScoped<IWorkoutPlanLogic, WorkoutPlanLogic>();

builder.Services.AddScoped<IRepoExercise, ExerciseGrpc>();
builder.Services.AddScoped<IExerciseLogic, ExerciseLogic>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseCors("AllowAllOrigins");
app.UseAuthorization();

app.MapControllers();

app.Run();