// requirements
var gulp = require('gulp'),
    rename = require('gulp-rename'),
    concat = require('gulp-concat'),
    notify = require('gulp-notify'),
    gdebug = require('gulp-debug'),
    jshint = require('gulp-jshint'),
    uglify = require('gulp-uglify'),
    gutil = require('gulp-util'),
    es = require('event-stream'),
    usemin = require('gulp-usemin'),
    clean = require('gulp-clean'),
    minifyCss = require('gulp-minify-css'),
    minifyHtml = require('gulp-minify-html'),
    rebaseCSS = require('gulp-css-rebase-urls'),
    bower = require('gulp-bower'),
    rev = require('gulp-rev'),
    ngAnnotate = require('gulp-ng-annotate'),
    gulpCopy = require('gulp-file-copy')
    urlAdjuster = require('gulp-css-url-adjuster'),
    wiredep = require('wiredep').stream;


//=============================================================================================================================================
//========================================================   Configuration    =================================================================
//=============================================================================================================================================
var buildConfigFile = 'build.xml.properties'; // Ant build configuration
var index_files = ['WebContent/index.html']; //HTML index pages

//=============================================================================================================================================
//========================================================   inline plugins   =================================================================
//=============================================================================================================================================
var gdebug = function (ops) {
    return es.map(function (file, done) {
        gutil.log("========== debug ======= file:  " + file.relative);
        done(null, file);
    });
};
//=============================================================================================================================================
//==============================================================    tasks    ==================================================================
//=============================================================================================================================================
var buildConfigProperties;
// ---------------------------------------    Reading properties   -----------------------------------------
gulp.task('readProperties', function (cb) {
    var properties = require("properties"),
        propertiesOptions = {
            path: true,
            namespaces: true,
            variables: true,
            vars: {
                env: process.env,
                basedir: "." //current location of Gruntfile.js
            }
        };
    gutil.log("Reading properties file '" + buildConfigFile + "'...");
    properties.parse(buildConfigFile, propertiesOptions, function (error, obj) {
        if (error) {
            console.log(error);
            return;
        }
        buildConfigProperties = obj;
	
        cb(null); // completing task
    });
});

gulp.task('gotoBuildLocation', ['readProperties'], function (cb) {
    process.chdir(buildConfigProperties.build.home); //========= IMPORTANT : the current directory changes from here!
    cb(null);
});


// -----------------------------------    get bower files and update html in build location  --------------------------------
gulp.task('bowerBuild', ['readProperties', 'gotoBuildLocation'], function () {
    return bower({directory: './lib'});
});
 
gulp.task('wiredepBuild', ['bowerBuild'], function () {
    return gulp.src(index_files)
         .pipe(wiredep({
            dependencies: true,
            devDependencies: false,
            directory: './lib'
        })).pipe(gulp.dest('.'));
});
 ///----------------------------- rename build index file -------------------
gulp.task('rename', ['readProperties'], function () {
	//TODO change this to support multiple index file
    gulp.src(buildConfigProperties.build.home + '/index.html')
		.pipe(rename("old.html"))
		.pipe(gulp.dest(buildConfigProperties.build.home));
});

// ---------------------------------------    process Html Files   -----------------------------------------
gulp.task('processHtmlFiles', ['readProperties','rename'], function () {
	console.log("changing files in : " + buildConfigProperties.build.home)
    return gulp.src(index_files)
        .pipe(usemin({
            css: [rebaseCSS({root:'WebContent'}), minifyCss(), rev()],
            js: [ngAnnotate(),uglify(),rev()],
            bowerjs: [ngAnnotate(),uglify(),rev()],
            state: [ngAnnotate(),uglify(),rev()]
        }))
        .pipe(gulp.dest(buildConfigProperties.build.home));
});

//-----------------------------------    get bower files and update html in developement   --------------------------------
gulp.task('gotoDevLocation', ['readProperties'], function (cb) {
    process.chdir(buildConfigProperties.webroot); //========= IMPORTANT : the current directory changes from here!
    cb(null);
});

gulp.task('bowerDev', ['gotoDevLocation'], function () {
    return bower({directory: './lib'});
});

gulp.task('wiredepDev', ['bowerDev'], function () {
    return gulp.src(index_files)
        .pipe(wiredep({
            dependencies: true,
            devDependencies: false,
            directory: './lib'
        })).pipe(gulp.dest('.'));
});


// ---------------------------------------    default   -----------------------------------------
gulp.task('default', ['processHtmlFiles']);
