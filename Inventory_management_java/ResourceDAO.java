package com.curonex.dao;

import java.util.List;

import com.curonex.Resources;
import com.curonex.enums.ResourceAvailabilityEnum;
import com.curonex.enums.ResourceCategoryEnum;
import com.curonex.exception.ResourceDAOException;

public interface ResourceDAO {

    Resources addResource(Resources resource) throws ResourceDAOException;

    Resources getResourceById(long resourceId) throws ResourceDAOException;

    List<Resources> getAllResources() throws ResourceDAOException;

    Resources updateResource(Resources resource) throws ResourceDAOException;

    boolean deleteResource(long resourceId) throws ResourceDAOException;

    List<Resources> getResourcesByHospital(long hospitalId)
            throws ResourceDAOException;

    List<Resources> getResourcesByCategory(ResourceCategoryEnum category)
            throws ResourceDAOException;

    List<Resources> getResourcesByAvailability(
            ResourceAvailabilityEnum status)
            throws ResourceDAOException;



}
