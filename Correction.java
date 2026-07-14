@Override
public Resources getResourceById(long resourceId)
        throws ResourceDAOException {

    try {
        Resources resource =
                resourceDatabase.get(resourceId);

        if (resource == null) {
            throw new ResourceDAOException(
                    "Resource not found with ID: "
                    + resourceId);
        }

        return resource;

    } catch (ResourceDAOException e) {
        throw e;

    } catch (Exception e) {
        throw new ResourceDAOException(
                "Unable to access resource", e);
    }
}
