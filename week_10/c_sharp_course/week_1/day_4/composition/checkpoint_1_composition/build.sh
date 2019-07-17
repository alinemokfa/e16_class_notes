#!/bin/sh

mcs -reference:nunit.framework.dll  Main.cs wizard_management/*.cs wizard_management_specs/*.cs behaviours/*.cs
